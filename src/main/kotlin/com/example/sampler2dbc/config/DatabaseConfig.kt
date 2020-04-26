package com.example.sampler2dbc.config


import io.r2dbc.spi.ConnectionFactories
import io.r2dbc.spi.ConnectionFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.r2dbc.connectionfactory.R2dbcTransactionManager
import org.springframework.data.r2dbc.core.DatabaseClient
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import org.springframework.transaction.ReactiveTransactionManager


@Configuration
@EnableR2dbcRepositories
class DatabaseConfig : AbstractR2dbcConfiguration() {

    @Bean
    fun transactionManager(@Qualifier("h2") connectionFactory: ConnectionFactory): ReactiveTransactionManager {
        return R2dbcTransactionManager(connectionFactory)
    }

    @Bean("h2")
    override fun connectionFactory(): ConnectionFactory {
        val connectionFactory = ConnectionFactories.get("r2dbc:h2:mem:///test?options=DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE")

        val client = DatabaseClient.create(connectionFactory)

        val publisher = client.execute {
            "CREATE TABLE CUSTOMER(ID UUID PRIMARY KEY, FIRST_NAME VARCHAR(50) NOT NULL, LAST_NAME  VARCHAR(50) NOT NULL);"
        }
                .fetch()
                .rowsUpdated()

        println("Rows update ${publisher.block()}")


        return connectionFactory
    }
}