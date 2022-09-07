import logo from './logo.svg';
import './App.css';
import { useState } from "react";

const getApiData = async () => {
  const response = await fetch("/api/hello").then((response) => response.json());
  console.log(response.message);
  //setGreeting(response);
};

function App() {
  const [greeting, setGreeting] = useState("");

  getApiData();

  return <div className="App"><header className="App-header">
                                      <img src={logo} className="App-logo" alt="logo" />

                                    </header>{greeting}</div>;
}

export default App;
