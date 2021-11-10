import './Button.css';

import React from 'react'

const Button = (props) => {
    return (
        <button className="btn">
            {props.btnTitle}
        </button>
    )
}

const ButtonVerde = (props) => {
    function chamarFuncao() {
        // setValue(e.target.value);
        props.clickButton();
    }
    return (
        <button className="btn-verde" onClick={chamarFuncao}>
            {props.title}
        </button>
    )
}

export {Button, ButtonVerde}



