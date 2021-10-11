import './Button.css';

import React from 'react'

const Button = (props) => {
    return (
        <button className="btn">
            {props.btnTitle}
        </button>
    )
}

const ButtonVerde = ({title}) => {
    return (
        <button className="btn-verde">
            {title}
        </button>
    )
}

export {Button, ButtonVerde}



