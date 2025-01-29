Mini Projet Java : e-Koudi Bank
Modèle de Conception : MVC (Model-View-Controller)
Le modèle MVC structure l'application en trois parties distinctes :

1. View (Vue)
Les vues représentent l'interface utilisateur. Elles affichent les informations à l'écran et permettent à l'utilisateur de saisir des entrées, mais elles ne réalisent aucun traitement logique.

2. Model (Modèle)
Cette couche s'occupe de tout ce qui est relatif aux données :

Entity (Entités) : Les entités sont des classes décrivant les données (par exemple : un client et les informations qui le traitent).
DAL (Data Access Layer) : Les classes DAL gèrent l'accès aux données dans la base de données, incluant les opérations comme SELECT, UPDATE, INSERT, etc.
BLL (Business Logic Layer) : Les classes BLL contiennent la logique métier, c'est-à-dire les règles et traitements appliqués aux données récupérées via les DAL.
3. Controller (Contrôleur)
Les contrôleurs servent d'intermédiaires entre les vues et les modèles. Ils :

Fournissent aux vues les informations nécessaires en passant par les BLL.
Transmettez les entrées des vues aux BLL pour effectuer des modifications dans la base de données.
Flux d'informations :
Model <= => Controller <= => View

Cette architecture permet de séparer les responsabilités, rendant le code plus modulaire, maintenable et extensible, tout en assurant un haut niveau d'abstraction.

Description de l'application : e-Koudi Banque
e-Koudi Bank est une application interne de gestion bancaire offrant plusieurs fonctionnalités :

Ajout d'un client et création de son compte (compte courant ou épargne).
Modification ou suppression d'un client et de ses comptes en cas de besoin.
Gestion des comptes clients : dépôts, retraits, transferts, etc.
Gestion des banquiers : ajout, suppression, modification des informations, y compris le salaire, sous la supervision du directeur général.
Cette application est strictement réservée aux membres de la banque (directeur, banquiers et clients). Chaque utilisateur doit s'authentifier avec un ID , un nom d'utilisateur , et un mot de passe pour accéder à ses fonctionnalités respectives.

Statistiques du projet
Nombre total de lignes de code : Plus de 5600 lignes .
Nombre total de fichiers (classes) : 46 fichiers .
Nombre total de méthodes : Plus de 370 méthodes .
Conclusion

Grâce à son architecture bien pensée (MVC), l'application e-Koudi Bank est conçue pour être robuste, extensible et facile à maintenir. Elle offre une solution efficace pour la gestion des opérations bancaires et des utilisateurs, tout en garantissant la sécurité des données.
