capitals ={"USA":"washington" ,
           "France":"Paris" ,
           "China":"Pechino" ,
           "Italy":"Rome" ,
           }


for key,value in capitals.items():
    print(key,value)

capitals.update({
    "Germany": "Berlin",
    "Netherland" : "Amsterdam"
})
    
for key,value in capitals.items():
    print(key,value)
