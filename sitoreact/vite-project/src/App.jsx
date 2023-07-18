import { useEffect } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

  import React, { useState } from "react";

  function App() {
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
        <button onClick={handleButtonClick}>Next Pokemon</button>
        <div>
          <h2>Pokemon Number: {pokemonNumber}</h2>
          <button onClick={fetchData}>Fetch Pokemon</button>
          {pokemonData && (
            <div>
              <h3>{pokemonData.name}</h3>
              <img src={pokemonData.sprites.front_default} alt="Pokemon" />
            </div>
          )}
        </div>
      </div>
    );
  }

  export default App;


// function App() {
//   const [count, setCount] = useState(1)
  /* 
    const faicose = async function () {
      const response = await fetch("https://pokeapi.co/api/v2/pokemon/1");
      return response;
    }
  
    faicose()
      .then(res => {
        let pippo = res.json();
        console.log(pippo);
      })
      .then(data => {
        console.log(data);
      })
      .catch(e => {
        console.log(e);
      })
   */


  //     const [posts, setPosts] = useState([]);
  //     useState(() => {
  //        fetch("https://pokeapi.co/api/v2/pokemon/")
  //           .then((response) => response.json())
  //           .then((data) => {
  //              console.log(data);
  //              setPosts(data);
  //           })
  //           .catch((err) => {
  //              console.log(err.message);
  //             });
  //         }, []);

  //   return (
  //     <>
  //       <div>
  //         <a href="https://vitejs.dev" target="_blank">
  //           <img src={viteLogo} className="logo" alt="Vite logo" />
  //         </a>
  //         <a href="https://react.dev" target="_blank">
  //           <img src={reactLogo} className="logo react" alt="React logo" />
  //         </a>
  //       </div>
  //       <h1>Vite + React</h1>
  //       <div className="card">
  //         <button onClick={() => setCount((count) => count + 2)}>
  //           count is {count}
  //         </button>
  //         <p>
  //           Edit <code>src/App.jsx</code> and save to test HMR
  //         </p>
  //       </div>
  //       <p className="read-the-docs">
  //         Click on the Vite and React logos to learn more
  //       </p>
  //     </>
  //   )
  // }

  // export default App