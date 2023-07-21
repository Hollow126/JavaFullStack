spesa = []
while True:
    scelta = int(input("scrivi 1 per aggiungere un oggetto alla lista "))
    if scelta ==1:
        elemento = input("inserisci il prossimo elemento")
        spesa.append(elemento)
    elif scelta ==0:
        print("la tua lista è "+ str(spesa))
        break

listaAcquisti = []
while True:
    scelta2 = int(input("premi 1 per acquistare, 0 per terminare"))
    if scelta2 == 1:
        elementoDaAcquistare = input("cosa vuoi acquistare ? ")
        spesa.remove(elementoDaAcquistare)
        listaAcquisti.append(elementoDaAcquistare)
        print(spesa)
        print("hai comprato" + str(listaAcquisti))
    elif scelta == 0 : 
        print ("programma cocluso, hai comprato " + str(listaAcquisti))
        break
