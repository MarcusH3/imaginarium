/* ---- particles.js config ---- */

particlesJS("bg", {
    "particles": {
        "number": {
            "value": 90,
            "density": {
                "enable": true,
                "value_area": 300
            }
        },
        "color": {
            "value": "#ffffff"
        },
        "shape": {
            "type": "circle",
            "stroke": {
                "width": 0,
                "color": "#000000"
            },
            "polygon": {
                "nb_sides": 5
            },
            "image": {
                "src": "img/github.svg",
                "width": 100,
                "height": 100
            }
        },
        "opacity": {
            "value": 0.5,
            "random": true,
            "anim": {
                "enable": true,
                "speed": 0.1,
                "opacity_min": 0.1,
                "sync": false
            }
        },
        "size": {
            "value": 1,
            "random": true,
            "anim": {
                "enable": true,
                "speed": 0.1,
                "size_min": 0.5,
                "sync": false
            }
        },
        "line_linked": {
            "enable": false,
            "distance": 150,
            "color": "#ffffff",
            "opacity": 0.4,
            "width": 1
        },
        "move": {
            "enable": true,
            "speed": 0.3,
            "direction": "none",
            "random": true,
            "straight": false,
            "out_mode": "out",
            "bounce": false,
            "attract": {
                "enable": false,
                "rotateX": 600,
                "rotateY": 1200
            }
        }
    },
    "interactivity": {
        "detect_on": "canvas",
        "events": {
            "onhover": {
                "enable": true,
                "mode": "grab"
            },
            "onclick": {
                "enable": true,
                "mode": "push"
            },
            "resize": true
        },
        "modes": {
            "grab": {
                "distance": 0,
                "line_linked": {
                    "opacity": 1
                }
            },
            "bubble": {
                "distance": 400,
                "size": 40,
                "duration": 2,
                "opacity": 8,
                "speed": 3
            },
            "repulse": {
                "distance": 200,
                "duration": 0.4
            },
            "push": {
                "particles_nb": 4
            },
            "remove": {
                "particles_nb": 2
            }
        }
    },
    "retina_detect": true
});



var myButton2 = document.getElementById("myButton1");
var myButton1 = document.getElementById("myButton2");

function fetchAndDisplayWord() {
    fetch("http://localhost:8080/api/quotes/random")
        .then(response => response.text())
        .then(quote => {
            myButton2.textContent = quote;
        })
        .catch(error => {
            console.error('There was an error fetching the quote!', error);
        });
}

function fetchAndDisplayImage() {
    fetch("http://localhost:8080/images/random")
        .then(response => response.blob())
        .then(blob => {
            var url = URL.createObjectURL(blob);
            var img = document.createElement('img');
            img.src = url;
            var imageContainer = document.getElementById('imageContainer');

            while (imageContainer.firstChild) {
                imageContainer.removeChild(imageContainer.firstChild);
            }

            imageContainer.appendChild(img);
        })
        .catch(error => {
            console.error('There was an error fetching the image!', error);
        });
}
myButton1.addEventListener("click", fetchAndDisplayImage);

myButton1.addEventListener("click", fetchAndDisplayWord );


