[![LeszczyTom](https://circleci.com/gh/LeszczyTom/ceri-m1-techniques-de-test.svg?style=svg)](https://app.circleci.com/pipelines/github/LeszczyTom/ceri-m1-techniques-de-test?filter=all)
[![codecov](https://codecov.io/gh/LeszczyTom/ceri-m1-techniques-de-test/branch/master/graph/badge.svg?token=IHHC7NL2HK)](https://codecov.io/gh/LeszczyTom/ceri-m1-techniques-de-test)
[![checkstyle](https://gist.githubusercontent.com/LeszczyTom/7c4b96672dae6e5b47f99194266ef5a9/raw/badge.svg)](https://checkstyle.sourceforge.io/)
# UCE Génie Logiciel Avancé : Techniques de tests
  
Leszczynski Tom M1ILSEN GR1

| TP|
| -----|
|✔ [Fork them all !](TPs/TP1.md)|
|✔ [(Dés)intégration continue](TPs/TP2.md)|
|✔ [Pokéunit](TPs/TP3.md)|
|✔ [100% IV](TPs/TP4.md)|
|✔ [Bulbapedia](TPs/TP5.md)|
|✔ [Ils sont de retour pour vous jouer un mauvais tour](TPs/TP6.md)|

La [Javadoc](https://www.leszczytom.fr/ceri-m1-techniques-de-test/fr/univavignon/pokedex/api/package-summary.html)
## TP6

[LE COMMIT](https://github.com/LeszczyTom/ceri-m1-techniques-de-test/commit/65350314249b5fdf24b78b91677d0327ed5702bc)

En ajoutant RocketPokemonFactory.java, checkstyle trouve 24 erreurs.

RocketPokemonFactory.java ne passe pas les tests.

Les IV sont mal gérés.

Des pokémons sont créés même quand l'id est supérieur à 150 ou inférieure à 0.
