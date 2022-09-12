import React from "react";
import MyRouter from "routers/index";
import { useState } from "react";

/*********************************************************************************************************/
const classNaming1 = "nc-Button relative h-auto inline-flex items-center justify-center rounded-full transition-colors text-sm sm:text-base font-medium px-4 py-3 sm:px-6  ttnc-ButtonPrimary disabled:bg-opacity-70 bg-primary-6000 hover:bg-primary-700 text-neutral-50  focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-primary-6000 dark:focus:ring-offset-0";
const classNaming2 = "inline-flex w-full justify-center rounded-md border border-transparent bg-red-600 px-4 py-2 text-base font-medium text-white shadow-sm hover:bg-red-700 focus:outline-none focus:ring-2 focus:ring-red-500 focus:ring-offset-2 sm:ml-3 sm:w-auto sm:text-sm";
const classNaming3 = "mt-6 flex w-full items-center justify-center rounded-md border border-transparent bg-indigo-600 py-3 px-8 text-base font-medium text-white hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:ring-offset-2";

const getApiData = async (callback: (arg0: string) => void, url: string) => {
  const response = await fetch("/api/" + url).then((response) => response.json());
  //console.log(response.message);
  callback(response.message);
};

function ApiTest() {
  const [greeting, setGreeting] = useState("React배워요~");
  return (
    <div>
      <button className={classNaming1} onClick={() => getApiData(setGreeting, "hello")}>
        HI
      </button>
      <button className={classNaming2} onClick={() => getApiData(setGreeting, "")}>
        API
      </button>
      <button className={classNaming3} onClick={() => getApiData(setGreeting, "bye")}>
        BYE
      </button>
      <h1 className="text-3xl md:text-4xl font-semibold">{greeting}</h1>
    </div>
  );
}
//테스트 부분
/*********************************************************************************************************/

function App() {
  return (
    <div className="bg-white text-base dark:bg-neutral-900 text-neutral-900 dark:text-neutral-200">
      <ApiTest />
      <MyRouter />
    </div>
  );
}

export default App;
