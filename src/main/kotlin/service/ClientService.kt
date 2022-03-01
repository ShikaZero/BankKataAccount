package service

import model.Client

class ClientService{

    val listOfClients: MutableList<Client> = mutableListOf(
        Client("0", "Eren", "Jaeger")
    )

    fun createClient(client: Client){
        listOfClients.add(client)
    }

    fun findClientById(clientId: String): Client {
        return clientId.takeIf { listOfClients.any { it.id == clientId } }?.let {
            listOfClients.first { it.id == clientId }
        }  ?: throw Exception("No client found with this id $clientId")
    }

}