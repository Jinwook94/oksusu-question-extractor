import {BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import PATH from './constants/path';
import HomePage from "./pages/HomePage";

const App = () => {
    return (
        <>
            <Router>
                <Routes>
                    <Route path={PATH.HOME} element={<HomePage/>}/>
                </Routes>
            </Router>
        </>
    );
};

export default App;
