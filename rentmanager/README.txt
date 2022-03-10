EPF - MIN - Léa Peissellon Berruti 
Projet rentmanager Java 
Encadré par Mathéo ALLARD et Ulysse COSCOY

-----------------------------------------------------------------------------------------------------------------------

Réalisé : 

- Créer un nouveau client 
- Créer un nouveau véhicule 
- Créer une nouvelle réservation 

- Supprimer un véhicule
- Supprimer une réservation

- Afficher la liste des clients avec la méthode FindALL
- Afficher la liste des véhicules avec la méthode FindALL

- Méthode findbyId pour les véhicules et clients
- Méthode findResaByClientId pour trouver une réservation en fonction de l'ID client
- Méthode findResaByVehicleId pour trouver une réservation en fonction de l'ID d'un véhicule

- Compteur du nombre de véhicles pour l'afficher dans la homepage
- Compteur du nombre de réservations pour l'afficher dans la homepage
- Compteur du nombre de clients pour l'afficher dans la homepage
- Méthode pour compter les réservations en fonction de l'iD du client (utile pour la page détails des clients)

- Modifier un client (en cliquant sur modifier, les champs sont préalablement remplis)

- Intégration du framework Spring

- Contrainte 1 : lors de la création d'un véhicule, tous les champs doivent être remplis et le nombre de place doit être compris entre 2 et 9.
- Contrainte 2 : lors de la création d'un client, tous les champs doivent être remplis
- Contrainte 3 : lors de la création d'une réservation, tous les champs doivent être remplis
- Contrainte 4 : Le nom et le prénom d'un client doivent faire au moins 3 caractères
- Contrainte 5 : Le nom des client s'affiche toujours en majuscule


-----------------------------------------------------------------------------------------------------------------------

Réalisé en partie : 

- Supprimer un client : il est possible de supprimer tous les clients à l'exception du premier de la liste. Je n'ai pas réussi à trouver l'erreur, 
  sachant qu'il s'agit de la même méthode que delete un véhicule ou réservation qui elles fonctionnent.

- Afficher les détails de chaque client (nom, prénom, adresse mail, nombre de réservation effectuées, liste des réservations effectuées) : Tout est
  affiché cependant une amélioration serait d'afficher le nom du client et le constructeur du véhicule plutôt que leurs id.
- Afficher la liste des réservations avec la méthode FindALL : Tout est affiché cependant une amélioration serait d'afficher le nom du client et le
  constructeur du véhicule plutôt que leurs id.

- Modifier un véhicule : je n'arrive pas à récupérer l'iD du véhicule à modifier, ce qui me provoque l"erreur " HTTP Status 500 - For input string: "" ". 
  Pourtant il s'agit de la même méthode que modifier un client qui elle fonctionne...


-----------------------------------------------------------------------------------------------------------------------

