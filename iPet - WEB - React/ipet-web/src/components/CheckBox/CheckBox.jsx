import React from "react";
import './CheckBox.css';

export function CheckBox({label}) {

  const [checked, setChecked] = React.useState(false);
 
  const handleChange = () => {
    setChecked(!checked);
  };

  return (
    <>      
          <div className="checkBox--div">
                <input
                className="checkBox--input"
                type="checkbox" 
                id="checkbox" 
                name="checkbox" 
                checked={checked}
                onClick={handleChange}/>
                
                <label 
                  for="checkbox" 
                  className="checkBox--label">
                    {label}
                </label>
          </div>
    </>
  );
}
