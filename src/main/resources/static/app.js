function generateImagination() {
    const imaginationBox = document.getElementById("imaginationBox");
    const randomImage = document.getElementById("randomImage");
    const randomQuoteElem = document.getElementById("randomQuote");

    // Logic to get a random image URL from /resources/images.
    const totalImages = 50;  // Total number of images you have. Change this to match your count.
    const imageIndex = Math.floor(Math.random() * totalImages) + 1;
    const imageUrl = `/resources/images/img${imageIndex}.jpg`;

    // Logic to get a random quote from the quote list.
    fetch('/getRandomQuote')
        .then(response => response.text())
        .then(quote => {
            randomImage.src = imageUrl;
            randomQuoteElem.textContent = quote;
            imaginationBox.style.display = "block";
        });
}
