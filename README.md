# Projet Festivals Bretons

## Introduction

Ce projet vise à créer une application Web pour la gestion de festivals bretons. Il permettra aux utilisateurs d'afficher, de créer, de modifier et de supprimer des festivals à partir d'une base de données.

## Prérequis

Les outils suivants sont nécessaires pour exécuter l'application :

- Java 11 ou supérieur
- Maven


## Installation

1. Clonez ce dépôt git : git clone <https://github.com/Andytomsingvien/FestivalsBreton>
2. Créez une base de données sans table.
3. Ouvrir le fichier application.properties dans le dossier resources
4. Ajoutez ces lignes et modifiez en fonction les 3 premières lignes :

    - spring.datasource.url=jdbc:mysql://localhost:3306/nom_bdd
    - spring.datasource.username=identifiant_bdd
    - spring.datasource.password=mot_de_passe_bdd
    - spring.jpa.hibernate.ddl-auto=update

## Utilisation

Une fois l'application en cours d'exécution, accédez à l'URL suivante dans votre navigateur : http://localhost:8080/. Vous pouvez maintenant utiliser l'application pour afficher, créer, modifier et supprimer des festivals.

## Fonctionnalités

Les fonctionnalités suivantes sont disponibles dans l'application :

- Afficher tous les festivals
- Afficher un festival spécifique
- Créer un nouveau festival (en cliquant sur la carte la latitude et longitude sont implantées automatiquement)
- Modifier un festival existant
- Supprimer un festival existant

## Auteurs

- CAP Solenne
- TOM SING VIEN Andy