import './Input.css';

import React, { useState } from 'react'


const Input = (props) => {
    return (
      <>
        <p className="txt-input">{props.txt}</p>
        <input className="input" placeholder={props.placeholder}></input>
      </>
    )
}

export default Input
