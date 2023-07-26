import math
def addizione(number1,number2):
    return number1+number2
def sotrazione(number1,number2):
    return number1-number2
def moltiplicazione(number1,number2):
    return number1*number2
def divisione(number1,number2):
    return number1/number2
def potenza(number1,number2):
    return number1*+number2
def radice (number1):
    return math.sqrt(number1)
def percentuale(number1,number2):
    return number1/100*number2
operazione= input("che tipo di calcolo vuoi fare ? ").capitalize()
number1=float(input("scrivi il primo numero"))


if operazione != "Radice":
    number2=float(input("scrivi il secondo numero"))
if operazione == "Addizione":
    print("il risultato è " + str(addizione(number1,number2)))
elif operazione == "Sotrazione":
    print("il risultato è " + str(sotrazione(number1,number2)))
elif operazione == "Moltiplicazione":
    print("il risultato è " + str(moltiplicazione(number1,number2)))
elif operazione == "Divisione":
    print("il risultato è " + str(divisione(number1,number2)))
elif operazione == "Potenza":
    print("il risultato è " + str(potenza(number1,number2)))
elif operazione == "Percentuale":
    print("il risultato è " + str(percentuale(number1,number2)))
elif operazione == "Radice":
    print("il risultato è " + str(radice(number1)))
else:
    print("non valido")