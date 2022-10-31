package sample.util

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.flywaydb.core.Flyway
import org.jetbrains.exposed.sql.Database

object DbInitializer {
    fun initDb(
        dbUrl: String,
        dbUser: String,
        dbPassword: String,
    ) {
        val dataSource = createDataSource(
            dbUrl = dbUrl,
            dbUser = dbUser,
            dbPassword = dbPassword,
        )

        Flyway.configure()
            .dataSource(dataSource)
            .load()
            .migrate()

        // ExposedのDB接続設定
        Database.connect(dataSource)
    }

    private fun createDataSource(
        dbUrl: String,
        dbUser: String,
        dbPassword: String,
    ): HikariDataSource = HikariConfig().apply {
        driverClassName = "org.postgresql.Driver"
        jdbcUrl = dbUrl
        username = dbUser
        password = dbPassword
        isAutoCommit = false
        validate()
    }.let { HikariDataSource(it) }
}