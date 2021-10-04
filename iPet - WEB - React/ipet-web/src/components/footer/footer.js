import './footer.css';
import instagram from '../../Assets/Instagram.png'
import twitter from '../../Assets/Twitter.png'
import facebook from '../../Assets/Facebook.png'
import pinterest from '../../Assets/Pinterest.png'
import youtube from '../../Assets/Youtube.png'

export function Footer(props) {
    return (
        <>
            <section className="footerMenu">
                <div className="footerItems">
                    <div className="footerItem">
                        {props.item1}
                    </div>
                    <div className="footerItem">
                        <h3>
                            {props.item2}
                        </h3>
                    </div>
                    <div className="footerItem">
                        <h3>
                            {props.item3}
                        </h3>
                    </div>
                    <div className="footerItem">
                        <h3>
                            {props.item4}
                        </h3>
                    </div>
                    <div className="payment">
                        <h3>
                            a
                            a
                            a
                            a
                        </h3>
                    </div>
                </div>
            </section>
            <section className="socialMediaFooter">
                <div className="grayRow"></div>
                <div className="socialMediaImages">
                    <img src={instagram} height="24px" width="24px" alt="none" />
                    <img src={twitter} height="24px" width="24px" alt="none" />
                    <img src={facebook} height="24px" width="24px" alt="none" />
                    <img src={pinterest} height="24px" width="24px" alt="none" />
                    <img src={youtube} height="24px" width="24px" alt="none" />
                </div>
                <div className="grayRow2"></div>
            </section>
            <div className="ipetInc">
                © IPET, Inc. 2021. We love our users!
            </div>
        </>
    )
}