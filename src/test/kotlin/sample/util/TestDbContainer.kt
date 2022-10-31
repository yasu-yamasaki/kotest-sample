package sample.util

import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.containers.wait.strategy.Wait
import org.testcontainers.utility.DockerImageName

object TestDbContainer {
    private val postgresqlContainer: PostgreSQLContainer<Nothing> =
        PostgreSQLContainer<Nothing>(DockerImageName.parse("postgres").withTag("13-alpine"))

    fun start() {
        if (postgresqlContainer.isCreated) {
            return
        }
        postgresqlContainer.start()
        postgresqlContainer.waitingFor(Wait.forListeningPort())
        Thread.sleep(2_000)
        DbInitializer.initDb(
            dbUrl = postgresqlContainer.jdbcUrl,
            dbUser = postgresqlContainer.username,
            dbPassword = postgresqlContainer.password,
        )
    }

    fun stop() {
        if (postgresqlContainer.isCreated) {
            postgresqlContainer.stop()
        }
    }
}