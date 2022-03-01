package service

import model.Client
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ClientServiceTest{

    private val clientService = ClientService()

    @Test
    fun `should create a client`() {
        //given
        val client = Client("1", "Naruto", "Uzumaki")

        //when
        clientService.createClient(client)

        //then
        assertEquals(true, clientService.listOfClients.any{ it.id == client.id})
        assertEquals(true, clientService.listOfClients.any{ it.firstName == client.firstName})
        assertEquals(true, clientService.listOfClients.any{ it.lastName == client.lastName})

    }

    @Test
    fun `should find a client`() {

        //given
        val clientId = "0"

        //when
        val clientResult = clientService.findClientById(clientId)

        //then
        assertTrue(clientResult.id == clientId)

    }

    @Test
    fun `should return an Exception if client id doest not exist`() {

        //given
        val clientId = "50"
        val expectedMessage = "No client found with this id $clientId"

        //when
        val exception: Exception = assertThrows(Exception::class.java) { clientService.findClientById(clientId) }

        //then
        assertTrue(exception.message.orEmpty().contains(expectedMessage));

    }



}