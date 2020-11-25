import React from 'react';
// import logo from './logo.svg';
import './App.css';

import Slideshow from './components/slideshow/slideshow';
import img1 from './components/slideshow/image/YourProduct1.png';
import img2 from './components/slideshow/image/YourProduct2.png';
import img3 from './components/slideshow/image/YourProduct3.jpg';
import img4 from './components/slideshow/image/YourProduct4.jpg';

const collection = [
  {src:img1, caption:"one"},
  {src:img2, caption:"two"},
  {src:img3, caption:"three"},
  {src:img4, caption:"four"}
]

console.log("ha duy hoang");

export default class App extends React.Component {
  render() {
    return (
      <Slideshow
        input={collection}
        ratio={`493:547`}
        mode={`manual`}
      />
    );
  }
}

// function App() {
//   return (
//     <div className="App">
//       <header className="App-header">
//         <img src={logo} className="App-logo" alt="logo" />
//         <p>
//           Edit <code>src/App.js</code> and save to reload.
//         </p>
//         <a
//           className="App-link"
//           href="https://reactjs.org"
//           target="_blank"
//           rel="noopener noreferrer"
//         >
//           Learn React
//         </a>
//       </header>
//     </div>
//   );
// }
// export default App;
