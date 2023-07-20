import React, { useState } from "react";


function ApiSetter() {
    


const [pokemonNumber, setPokemonNumber] = useState(1);
const [pokemonData, setPokemonData] = useState(null);

const fetchData = () => {
    fetch(`https://pokeapi.co/api/v2/pokemon/${pokemonNumber}`)
        .then((response) => response.json())
        .then((data) => {
            console.log(data);
            setPokemonData(data);
        })
        .catch((err) => {
            console.log(err.message);
        });
};

const handleButtonClick = () => {
    setPokemonNumber((prevNumber) => prevNumber + 1);
};



return (
    <div>
    <h2>Pokemon Number: {pokemonNumber}</h2>
    <button onClick={fetchData}>Fetch Pokemon</button>
    {pokemonData && (
        <div>
            <h3>{pokemonData.name}</h3>
            <img src={pokemonData.sprites.front_default} alt="Pokemon" />
        </div>
    )}
      <button onClick={handleButtonClick}>Next Pokemon</button>
</div>
)}
export default ApiSetter