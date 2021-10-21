import Reat from 'react';
import './toast.css';
import { AiOutlineClose } from "react-icons/ai";

export default (props) => {
    function closeToast() {
        props.changeValueToast(false);
    }
    if (props.showToast === true) {
        setInterval(() => {
            props.changeValueToast(false)
        }, 7000)
    }
    return (
        <div id="toast" className={props.color + " toast " + props.showToast}>
            <div className="flex justify-content-between align-center">
                <h3>{props.text}</h3>
                <AiOutlineClose onClick={closeToast}/>
            </div>
        </div>
    )
}