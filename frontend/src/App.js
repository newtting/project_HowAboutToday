import logo from './logo.svg';
import './App.css';
import { useState } from "react";

const getApiData = async (callback) => {
  const response = await fetch("/api/bye").then((response) => response.json());
  console.log(response.message);
  callback(response.message);
};

function App() {
  const [greeting, setGreeting] = useState("");

  getApiData(setGreeting);

  return <div className="App"><header className="App-header"><h1>{greeting}</h1>
                                      <img src={logo} className="App-logo" alt="logo" />

                                    </header></div>;
}

export default App;
