# Commandroid

Commandroid è un applicazione Android realizzata come progetto per il corso di *Ingegneria del Software* tenuto dal Prof. Agostino Cortesi.

L'applicazione è in grado di inviare comandi ad un LEGO Mindstrom EV3 per stampare un testo o una figura disegnata sullo smartphone che segua la struttura di una matrice già predisposta. La comunicazione con il robot LEGO Mindstorm EV3 è stata possibile grazie alla libreria [`Legodroid`](https://github.com/alvisespano/Legodroid) realizzata da Alvise Spanò.

Il team di sviluppo è composto da:
* Giorgio Boscolo Bragadin ([@GiorgioBoscoloB](https://github.com/GiorgioBoscoloB))
* Lorenzo Padoan ([lurenss](https://github.com/lurenss))
* Pietro Rampazzo ([peterampazzo](https://github.com/peterampazzo))
* Andrea Tiozzo Cannella ([Andrea9090](https://github.com/Andrea9090))

### Requisiti

Per l’utilizzo dell’applicazione è necessario avere: 
* un kit base Lego Mindstorm EV3
* due [sensori di contatto](https://shop.lego.com/it-IT/product/Sensore-di-contatto-EV3-45507)
* uno smartphone Android (versione minima supportata Android 5.0 Lollipop)

Prima dell'utilizzo dell'applicazione è necessario attivare il Bluetooth del proprio smartphone e associare il LEGO Mindstorm EV3. Il nome di riconoscimento dell'interfaccia Bluetooth del robot deve essere quello di default, `EV3`.

### Funzionalità

Sono state sviluppate tre funzionalità. La prima ci permette di verificare che non ci siano problemi con la comunicazione e con il set up del kit. Per poter avviare questa funzionalità è necessario attivare lo switch presente nella schermata principale e cliccare sul sensore di contatto abbinato a tale funzionalità.

È possibile poi utilizzare le rimanenti due funzionalita che sono interamente personalizzabili dall'utente:
1. Nella prima è possibile disegnare una pixelart seguendo la struttura già preddisposta di una matrice 
2. Invece nella seconda è possibile digitare un testo - la codifica in pixel art verrà realizzata interamente dall'applicazione 

In ogni momento, in caso di problematiche, si può bloccare e resettare la stampa cliccando sul secondo sensore di contatto.
