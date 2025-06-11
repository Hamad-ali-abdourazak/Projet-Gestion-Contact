# Projet Gestion Contacts

Ce projet Java permet de gérer des contacts via une base de données MySQL.

---

## Structure du projet

- `src/` : code source Java  
- `base_de_donnees/` : contient le script SQL pour créer et peupler la base de données

---

## Importer la base de données MySQL

Le fichier `base_de_donnees/contact.sql` contient le script SQL pour créer la base de données, les tables nécessaires, ainsi que pour insérer les données initiales.

Pour importer la base de données, utilise la commande suivante dans un terminal :

```bash
mysql -u ton_utilisateur -p nom_de_la_base < base_de_donnees/contact.sql

## Importer et lancer le projet Java dans NetBeans

1. Cloner le dépôt GitHub  
Ouvre un terminal et exécute :

git clone https://github.com/Hamad-ali-abdourazak/Projet-Gestion-Contact.git
