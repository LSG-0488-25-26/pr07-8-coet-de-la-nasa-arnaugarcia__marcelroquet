# 🚀 COET DE LA NASA
## Descripció del projecte
* Aquesta aplicació utilitza una **API de països** per mostrar **informació detallada d'aquests**, poder crear una **llista de països preferits** i poder fer un **quiz de banderes** .

## Arquitectura
- Navegació amb **Routes**
- Arquitectura **MVVM** amb **LiveData**
- Integració d’API mitjançant **Retrofit**
- Base de dades local amb **Room**
- Llistes eficients amb **LazyColumn**
- **Scaffold** amb **TopBar** i **BottomBar**
- Disseny **adaptatiu**


## Vista principal
Vista principal on es mostra un **LazyColumn** amb la llista de països. 
- Cada **Card** conté informació bàsica del país. 
- Es mostren la **TopBar** i la **BottomBar**. 
- Possibilitat de navegar amb la BottomBar a  la vista de  preferits i al quiz. 
- Inclou un cercador per filtrar països pel nom.
<img width="238" height="505" alt="image" src="https://github.com/user-attachments/assets/cfbc6d2a-d8a1-4ead-8138-b111b455af06" />


## Vista detall
Vista  on es mostra informació detallada del país. 

<img width="238" height="505" alt="image" src="https://github.com/user-attachments/assets/7f5ba4c7-fc49-4409-95b7-b47ef83d675d" />


## Vista de preferits 
Vista  on es mostra un **LazyColumn** amb la llista de països preferits del usuari i si no té cap preferit es mostra un missatge. 

<img width="238" height="505" alt="image" src="https://github.com/user-attachments/assets/b96c9a11-f40c-4cb2-94fa-dfcea88c7195" />

<img width="238" height="505" alt="image" src="https://github.com/user-attachments/assets/faeb65d0-5f04-4573-afcc-cd03b2a7c5fd" />

## Quiz
Vista  on es mostrà una bandera on l'usuari haurà d'adivinar el país entre quatre opcions.

<img width="361" height="808" alt="image" src="https://github.com/user-attachments/assets/8900d1d9-1b27-47c4-8de0-f7696254f608" />


## Top Bar
El **TopBar** inclou una icona de lupa que permet:
- Mostrar o amagar el **Search Bar**
- Filtrar països pel seu nom

<img width="370" height="792" alt="image" src="https://github.com/user-attachments/assets/e2064dfb-ec03-46b4-9184-ddf178eb829b" />

  
## Bottom Bar
El **BottomBar**, situada a la part inferior de l’aplicació, conté tres botons:

- **Home**: torna a la llista general del paísos. 
- **Preferits**: mostra únicament els països preferits
- **Quiz**: mostra una bandera amb quatre opcions de país. 

