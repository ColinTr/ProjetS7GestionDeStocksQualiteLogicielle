# Guide de déploiement
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=AppPointage&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=AppPointage) [![Bugs](https://sonarcloud.io/api/project_badges/measure?project=AppPointage&metric=bugs)](https://sonarcloud.io/dashboard?id=AppPointage) 

Ce document est un guide de déploiement du logiciel issu du projet de qualité logiciel **gestion de stock**. Les auteurs sont Guillaume Bouchard et Colin Troisemaine.

## Qu'est-ce que c'est ?

Cette application est un projet Maven écrit en Java et permet de gérer des stocks de magasin. Le but de ce projet était d'utiliser un maximum d'outils visant à améliorer la qualité du logiciel.

## Installation

Les prérequis pour faire fonctionner l'application sont les suivants : Il faut avoir Java 11 d'installé et disposer d'une base de données MySQL. Par défaut cette base doit être accessible à l'adresse _127.0.0.1/projet_gestion_de_stocks_ mais il possible de changer l'adresse depuis la fenêtre de connexion. Le compte root (sans mot de passe) doit également exister sur la base de données.

Pour mettre en place notre application, il faut donc suivre les étapes suivantes :
1) Disposer d'un base de données à l'adresse _127.0.0.1/projet_gestion_de_stocks_ avec un compte root sans mot de passe.
2) Pour générer un magasin avec des rayons/produits/utilisateurs de test, exécuter GenererBDDDeTest.jar
3) Vous pouvez à présent lancer AppGestionDeStocks-1.0.jar et vous connecter avec l'un des trois comptes suivants :
	- En tant que chef de rayon : user / user
	- En tant que chef de magasin : admin / admin
	- En tant que PDG : azer / azer

Pour générer une base de données de test avec, puisque GenerationBDDDeTest.jar ne dispose pas d'interface, il faut changer l'adresse dans le fichier ./src/main/resources/META-INF/persistence.xml dans le persistence-unit **modeCreate** et régénérer le JAR.

## Tests d'intégration 

Les tests d'intégration s'effectuent sur une base de données différente de celle de production. Elle est par défaut nommée **projet_gestion_de_stocks_TEST**, comme pour la base de données classique elle est située en local avec l'utilisateur root et sans mot de passe. Vous pouvez modifier ses paramètres directement dans le fichier persistence.xml.

Voici une commande docker qui permet de lancer une base de données en local (sur le port 3306) pour effectuer les tests d'intégrations : 


	docker run --name testDB -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -d -p 3306:3306 -e MYSQL_DATABASE=projet_gestion_de_stocks_TEST mysql

 
