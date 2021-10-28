import React from 'react';
import './HomePage.css';
import { Menu } from "../../components/menu/Menu";
import { IntroPet } from '../../components/introPet/IntroPet';

export function HomePetShop() {
    return (
        <>
            <Menu />
            <IntroPet />
            <div className=""></div>
            <section className="clientFeedback">
                <div className="client1">
                    <div className="imgClient1">
                    </div>
                    "Consegui ter mais visibilidade e aumentar a renda do meu PetShop usando o
                    iPet cadastrando meus produtos e serviços"
                </div>
                <div className="client2">
                    “ Consegui ter mais visibilidade e
                    aumentar a renda do meu PetShop
                    usando o iPet e cadastrando meus
                    produtos e serviços “
                </div>
            </section>
            <section className="clientFeedback">
                <div className="client3">
                    “ Consegui ter mais visibilidade e
                    aumentar a renda do meu PetShop
                    usando o iPet e cadastrando meus
                    produtos e serviços “
                </div>
                <div className="client4">
                    “ Consegui ter mais visibilidade e
                    aumentar a renda do meu PetShop
                    usando o iPet e cadastrando meus
                    produtos e serviços “
                </div>
            </section>
        </>
    )
}