# Swing et Dominos

> Implémenation d'un jeu de domino et ses variantes en Java

---

## Avant-propos


## Sommaire

* Réflexions sur la conception
* Choix d'architecture

### Réflexions sur la conception du jeu

Le jeu de domino se joue en général entre amis, sur une table, avec un certain nombre de pions déjà fixé. On peut jouer à 2,3 ou 4 amis. Le principe de base du domino se construit autour de pièces, ayant chacunne 2 côtés. 

On commence par avoir une vision aussi abstraite que possible du jeu, de façon à pouvoir implémenter ses variantes plus facilement, et éviter des erreurs d'architecture. Tout d'abord, commençont par la table.

La table sur laquelle nous allons jouer va donc être une liste double, dont la taille se décidera au début du jeu. Elle permettra de déterminer la position d'une pièce au court du jeu, mais nécéssitera l'implémentation d'une fonctionnalité qui vérifiera que l'on ne pause pas une pièce en dehors du plateau.

La pièce en elle-même sera un objet contenant une position et une valeur. Le domino sera lui constitué de deux pièces, avec en plus une orientation qui déterminera comment les deux pièces sont positionnées l'une par rapport à l'autre.  

Le jeu se joue au tour par tour. Il convient donc de mettre en place une face de distribuer les differents tours aux joueurs. Il convient donc de réfléchir à la conception du joueur.


## Conclusion

