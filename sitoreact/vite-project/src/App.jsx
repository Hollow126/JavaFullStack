import { useState } from 'react'
import { useEffect } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {
  const [count, setCount] = useState(0)
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

    const [posts, setPosts] = useState([]);
    useEffect(() => {
       fetch("https://pokeapi.co/api/v2/pokemon/1")
          .then((response) => response.json())
          .then((data) => {
             console.log(data);
             setPosts(data);
          })
          .catch((err) => {
             console.log(err.message);
            });
        }, []);

  return (
    <>
      <div>
        <a href="https://vitejs.dev" target="_blank">
          <img src={viteLogo} className="logo" alt="Vite logo" />
        </a>
        <a href="https://react.dev" target="_blank">
          <img src={reactLogo} className="logo react" alt="React logo" />
        </a>
      </div>
      <h1>Vite + React</h1>
      <div className="card">
        <button onClick={() => setCount((count) => count + 2)}>
          count is {count}
        </button>
        <p>
          Edit <code>src/App.jsx</code> and save to test HMR
        </p>
      </div>
      <p className="read-the-docs">
        Click on the Vite and React logos to learn more
      </p>
    </>
  )
}

export default App
