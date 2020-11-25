import React from 'react';
import ReactDOM from 'react-dom';
import './slideshow.css';

export default class Slideshow extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            slideIndex : 0
        }

        const arrRatioWidthHeight = this.props.ratio.split(":");

        this.ratioWH = arrRatioWidthHeight[0]/arrRatioWidthHeight[1];
        this.backward = this.backward.bind(this);
        this.forward = this.forward.bind(this);
        this.setSlideIndex = this.setSlideIndex.bind(this);
        this.getNewSlideIndex = this.getNewSlideIndex.bind(this);
        this.updateDimensions = this.updateDimensions.bind(this);
        this.runAutomatic = this.runAutomatic.bind(this);
    }

    getNewSlideIndex(step) {
        const slideIndex = this.state.slideIndex;
        const numberSlide = this.props.input.length;
        let newSlideIndex = slideIndex + step;
        if (newSlideIndex > numberSlide) newSlideIndex = 0;
        else if (newSlideIndex < 0) newSlideIndex = numberSlide - 1;
        return newSlideIndex;
    }

    backward () {
        this.setState ({
            slideIndex : this.getNewSlideIndex(-1)
        })
    }

    forward () {
        this.setState ({
            slideIndex : this.getNewSlideIndex(1)
        })
    }

    setSlideIndex (index) {
        this.setState ({
            slideIndex : index
        })
    }

    updateDimensions() {
        this.containerSlide.style.height = `${this.containerSlide.offsetWidth / this.ratioWH}px`;
    }

    runAutomatic() {
        this.setState({
          slideIndex: this.getNewSlideIndex(1)
        });
    }

    componentDidMount() {
        this.rootElm = ReactDOM.findDOMNode(this);
        this.containerSlide = this.rootElm.querySelector(".slide-container");
        this.containerDot = this.rootElm.querySelector(".dot-container");

        this.updateDimensions();
    }

    render() {
        let content = (
        <div className="container-slideshow">
            <div className="slide-container">
                {
                    this.props.input.map((image, index) => {
                        return (
                            <div key={index} className={`slide ${this.state.slideIndex === index ? "slide-active" : ""}`}>
                                <img src={image.src} alt={image.caption}/>
                            </div> 
                        )
                    })
                }
            </div>
            <div className="dot-container">
                {
                    this.props.input.map((image, index) => {
                        return (
                            <div 
                                key={index} 
                                className={`dot ${this.state.slideIndex === index ? "dot-active" : ""}`}
                                onClick={() => this.setSlideIndex(index)}
                                >
                            </div> 
                        )
                    })
                }
            </div>
        </div>
        );
        return content;
    };

}