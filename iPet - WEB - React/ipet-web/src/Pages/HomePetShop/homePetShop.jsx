import React from 'react';
import './HomePage.css';
import { Menu } from "../../components/menu/Menu";
import { IntroPet } from '../../components/introPet/IntroPet';

import client1 from '../../Assets/client1.png'
import client2 from '../../Assets/client2.png'
import client3 from '../../Assets/client3.png'
import client4 from '../../Assets/client4.png'
import bolaAmarela from '../../Assets/bolaAmarela.png'
import novosClientes from '../../Assets/novosClientes.png'
import dinheiro from '../../Assets/dinheiro.png'
import { Footer } from '../../components/footer/footer';

export function HomePetShop() {
    return (
        <>
            <Menu />
            <IntroPet />
            <div className=""></div>
            <section className="clientFeedback">
                <div className="client1">
                    <div className="imgClient1">
                        <img src={client1} alt="none" />
                    </div>
                    "Consegui ter mais visibilidade e aumentar a renda do meu PetShop usando o
                    iPet cadastrando meus produtos e serviços"
                </div>
                <div className="client2">
                    <div className="imgClient2">
                        <img src={client2} alt="none" />
                    </div>
                    “ Consegui ter mais visibilidade e
                    aumentar a renda do meu PetShop
                    usando o iPet e cadastrando meus
                    produtos e serviços “
                </div>
            </section>
            <section className="clientFeedback">
                <div className="client3">
                    <div className="imgClient3">
                        <img src={client3} alt="none" />
                    </div>
                    “ Consegui ter mais visibilidade e
                    aumentar a renda do meu PetShop
                    usando o iPet e cadastrando meus
                    produtos e serviços “
                </div>
                <div className="client4">
                    <div className="imgClient4">
                        <img src={client4} alt="none" />
                    </div>
                    “ Consegui ter mais visibilidade e
                    aumentar a renda do meu PetShop
                    usando o iPet e cadastrando meus
                    produtos e serviços “
                </div>
            </section>
            <section>
                <div className="ipetPartner">
                    <div className="partnerimgs">
                        <div>
                            <img src={bolaAmarela} alt="none" />
                            <div className="novosClientes">
                                <img src={novosClientes} alt="none" />
                            </div>
                        </div>
                        <div>
                            <img src={bolaAmarela} alt="none" />
                            <div className="dinheiro">
                                <img src={dinheiro} alt="none" />
                            </div>
                        </div>
                        <div><img src={bolaAmarela} alt="none" /></div>
                        <div><img src={bolaAmarela} alt="none" /></div>
                    </div>
                </div>
            </section>

            <Footer item1="Termos e condições de usos" item2="Políticas e termos" item3="Help desk" item4="Formas de pagamento" />
        </>
    )
}