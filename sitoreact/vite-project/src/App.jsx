import { useEffect } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import React, { useState } from "react";
import ThemeSwitcher from './components/ThemeSwitcher';
import MenuNavbar from './components/MenuNavbar';
import ApiSetter from './components/ApiSetter';
import Container from 'react-bootstrap/Container';
function App() {





  function handleData(data) {
    // Utilizza i dati ricevuti dal componente figlio
    console.log(data);
  }



  return (
    <div>
      <MenuNavbar />
      <Container
        style={{
          backgroundColor: 'green',
          width: '90%'
        }}>

        <ThemeSwitcher onData={handleData} />

        <ApiSetter />

      </Container>
    </div>

  );
}

export default App;