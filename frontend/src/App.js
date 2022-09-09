import logo from "./logo.svg";
import "./App.css";
import { useState } from "react";

const getApiData = async (callback, url) => {
  const response = await fetch("/api/" + url).then((response) => response.json());
  //console.log(response.message);
  callback(response.message);
};

function App() {
  const [greeting, setGreeting] = useState("React배워요~");


  return (
    <div className="App">
      <header className="App-header">
        <button onClick={() => 
          getApiData(setGreeting, 'hello')
        }>HI</button>
        <button onClick={() => 
          getApiData(setGreeting, '')
        }>API</button>
        <button onClick={() => 
          getApiData(setGreeting, 'bye')
        }>BYE</button>
        <h1>{greeting}</h1>
        <img src={logo} className="App-logo" alt="logo" />
      </header>
    </div>
  );
}

export default App;
