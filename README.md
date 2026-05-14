# 🗡️ LA MAZMORRA DE MEDAC 🗡️
Bienvenido a MEDAC open, un juego de rol por consola hecho en Java. Básicamente, es un simulador de supervivencia donde tienes que abrirte paso a base de palos por 10 pisos llenos de fauna de clase: profes de base de datos, pijos de gimnasio, repetidoras y un jefe final.

## ¿Qué es?
Eliges a tu héroe (Fonso, Chum chum, Joseca o Julio) y te metes. Cada piso es un combate por turnos contra un bicho aleatorio. Tienes que pensar un poco y gestionar tu Vida (HP) y tu Maná (MP) para no palmar antes de llegar al tejado.

### Mecánicas que tienes que controlar:

>Combate por turnos: Tú decides qué ataque tirar. Algunos pegan más fuerte, otros gastan más maná, y otros dejan al enemigo envenenado o atontado perdiendo el turno.

>Mochila salvavidas: Tienes Bifrutas para curarte vida y Cafeles para recuperar maná. Te dan uno de cada cuando limpias un piso, así que no los gastes a lo loco.

>Eventos aleatorios: Entre pelea y pelea, pueden pasarte cosas random por los pasillos. Puedes encontrar botín, recuperar stats echando un piti o llevarte un calambrazo en una máquina de vending.

>>>*El Boss Final*: En el piso 10 te espera Javi. Y ojo, que cuando crees que te lo has cargado... se toma un café del Aldi y entra en fase 2.

## 📂 Cómo está montado el chiringuito
El código está dividido en 4 clases bastante limpias para que no sea un caos mental leerlo:

>Main.java: Es el cerebro de la operación. Aquí tienes el menú principal, la ruleta rusa que elige a los enemigos, y el bucle infinito de los combates (donde te pegas de hostias).

>Personaje.java: Es la plantilla con la que se crean tanto los héroes como los enemigos. Controla si estás vivo, cuánta vida te queda, qué llevas en la mochila y si te estás muriendo por veneno.

>Ataque.java: El arsenal. Define cuánto daño hace una habilidad, el maná que chupa y si tiene algún efecto guapo (como Aturdir). Además, tiene una función para que tus ataques peguen más fuerte según subes de piso.

>Evento.java: La clase del salseo. Se encarga de sacarte pantallitas de texto aleatorias cuando ganas un combate para darte premios o putearte un poco.