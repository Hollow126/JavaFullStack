import { useState } from "react";
import { Button, ButtonGroup, Dropdown } from "react-bootstrap";
import '../index.css'

const ThemeSwitcher = (props) => {
    const [value, setValue] = useState(null);
  
    function handleClick(newValue) {
      setValue( newValue);
      const data = {newValue};
      props.onData(data);
    }
  
    return (
      <div className="mb-2 central-button">
        <button onClick={() => handleClick(1)}>Gen 1</button>
        <button onClick={() => handleClick(2)}>Gen 2</button>
        <button onClick={() => handleClick(3)}>Gen 3</button>
        <button onClick={() => handleClick(4)}>Gen 4</button>
        <button onClick={() => handleClick(5)}>Gen 5</button>
      </div>
    );
  };
  
export default ThemeSwitcher;