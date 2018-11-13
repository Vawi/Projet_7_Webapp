#Partie webapp du projet 7


Cette partie de l'application permet aux visiteurs de :
- consulter la liste de l'intégralité des ouvrages de la bibliothèque
- consulter la liste des ouvrages disponibles au sein de la bibliothèque

Elle permet de plus à l'utilisateur authentifié de :
- visualiser la liste de l'intégralité de ces emprunts passé et en cours
- prolonger un emprunt dans la mesure ou celui ci n'a pas deja été prolongé. 

Une partie de la webapp a été généré a l'aide d'apache CXF, et elle est constuite a l'aide de spring et struts 2 et d'un serveur tomcat

Cette partie ne se connecte pas a la db, elle necessite obligatoirement que le service soit lancé (sur le port 8080) pour afficher des données.

La méthode pour lancer la webapp est quasiment la meme que pour la partie service :
- le projet doit etre packagé avec maven afin d'obtenir un war (mvn package)
- ensuite le projet doit etre lancer a l'aide de tomcat, cependant il doit fonctionner sur le port 8081, etant donnée que le service occupe deja le port 8080
