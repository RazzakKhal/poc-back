# Your Car, Your Way - Backend

Ce backend en Spring Boot fournit les API REST et WebSocket nécessaires à l'application **Your Car, Your Way** pour la gestion de la communication en temps réel via un chat entre utilisateurs et agents de support. Ce document explique comment installer, configurer et exécuter le backend, ainsi que les dépendances et bibliothèques utilisées.

## Prérequis

- **Java 17**
- **Maven**
- **MySQL** pour la base de données (ou un autre SGBD compatible si adapté)

## Installation

1. Clonez le dépôt :
   ```bash
   git clone <repository-url>
   cd poc-back
   ```

2. Compilez et packagez le projet avec Maven :
   ```bash
   mvn clean install
   ```

## Configuration

### Base de Données

Le backend utilise MySQL pour la gestion des données. Configurez les paramètres de connexion dans `src/main/resources/application.properties` :

```properties
spring.application.name=poc-back
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/poc-back?createDatabaseIfNotExist=true&serverTimezone=UTC
spring.jpa.show-sql=true
server.port=3001
api.url=http://localhost:3001/
spring.datasource.username=your_username
spring.datasource.password=your_password
```

Remplacez `your_username` et `your_password` par les valeurs appropriées pour votre base de données.

### Initialisation de la Base de Données

1. **Lancez l'application une première fois** pour que la base de données **`poc-back`** et les tables associées soient créées automatiquement.

2. **Ajoutez deux utilisateurs factices** pour tester le chat en exécutant les commandes SQL suivantes :

   ```sql
   INSERT INTO USER (name, email) VALUES ('razzak', 'razzak@example.com');
   INSERT INTO USER (name, email) VALUES ('support', 'support@example.com');
   ```

Ces utilisateurs serviront pour simuler les rôles d'un utilisateur connecté et d'un agent de support.

## Lancement du Serveur

Une fois les configurations terminées, démarrez le serveur Spring Boot :

```bash
mvn spring-boot:run
```

Le serveur sera accessible par défaut sur [http://localhost:3001](http://localhost:3001).

## Fonctionnalités

- **API REST** : Fournit les endpoints pour la gestion des utilisateurs et des messages.
- **WebSocket** : Gère la communication en temps réel pour le chat entre les utilisateurs et les agents de support.
- **Persistance des Données** : Utilise JPA avec une base de données MySQL pour stocker les informations des utilisateurs et des messages.

## Principales Dépendances

Les principales bibliothèques utilisées dans ce projet sont :

- **spring-boot-starter-data-jpa** : pour la gestion des données et l'intégration de JPA.
- **spring-boot-starter-web** : pour la création d'API REST.
- **spring-boot-starter-websocket** : pour l'implémentation du protocole WebSocket pour les communications en temps réel.

