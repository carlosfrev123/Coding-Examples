const button = document.querySelector('#new-quote');
button.textContent = "Click to generate a motivational Quote!";
button.className = "my-button";
// document.createElement
const container = document.querySelector('.container');
let a = document.createElement('a');



// const textBox = document.querySelector('textBox'); 


const quotes = [
    "\"The only way to do great work is to love what you do.\" - Steve Jobs",
    "\"Believe you can and you're halfway there.\" - Theodore Roosevelt",
    "\"Don't watch the clock; do what it does. Keep going.\" - Sam Levenson",
    "\"Success is not final, failure is not fatal: It is the courage to continue that counts.\" - Winston Churchill",
    "\"The future belongs to those who believe in the beauty of their dreams.\" - Eleanor Roosevelt",
    "\"Your time is limited, don't waste it living someone else's life.\" - Steve Jobs",
    "\"The only limit to our realization of tomorrow will be our doubts of today.\" - Franklin D. Roosevelt",
    "\"Believe in yourself and all that you are. Know that there is something inside you that is greater than any obstacle.\" - Christian D. Larson",
    "\"The harder you work for something, the greater you'll feel when you achieve it.\" - Unknown",
    "\"The only person you are destined to become is the person you decide to be.\" - Ralph Waldo Emerson",
    "\"It does not matter how slowly you go as long as you do not stop.\" - Confucius",
    "\"Don't be pushed around by the fears in your mind. Be led by the dreams in your heart.\" - Roy T. Bennett",
    "\"Success is not the key to happiness. Happiness is the key to success. If you love what you are doing, you will be successful.\" - Albert Schweitzer",
    "\"The best way to predict the future is to create it.\" - Peter Drucker",
    "\"You are never too old to set another goal or to dream a new dream.\" - C.S. Lewis",
    "\"The secret of getting ahead is getting started.\" - Mark Twain",
    "\"Your time is now. Start where you are and never back down.\" - Roy T. Bennett",
    "\"The only place where success comes before work is in the dictionary.\" - Vidal Sassoon",
    "\"Success is walking from failure to failure with no loss of enthusiasm.\" - Winston Churchill",
    "\"Don't be afraid to give up the good to go for the great.\" - John D. Rockefeller",
    "\"The way to get started is to quit talking and begin doing.\" - Walt Disney",
    "\"The future depends on what you do today.\" - Mahatma Gandhi",
    "\"The only thing standing between you and your goal is the story you keep telling yourself as to why you can't achieve it.\" - Jordan Belfort",
    "\"Life is 10% what happens to us and 90% how we react to it.\" - Charles R. Swindoll",
    "\"The biggest risk is not taking any risk. In a world that is changing quickly, the only strategy that is guaranteed to fail is not taking risks.\" - Mark Zuckerberg",
    "\"In the middle of difficulty lies opportunity.\" - Albert Einstein",
    "\"Challenges are what make life interesting and overcoming them is what makes life meaningful.\" - Joshua J. Marine",
    "\"The best revenge is massive success.\" - Frank Sinatra",
    "\"Success is not in what you have, but who you are.\" - Bo Bennett",
    "\"The future starts today, not tomorrow.\" - Pope John Paul II",
    "\"The only way to achieve the impossible is to believe it is possible.\" - Charles Kingsleigh (Alice in Wonderland)",
    "\"Don't let yesterday take up too much of today.\" - Will Rogers",
    "\"Success usually comes to those who are too busy to be looking for it.\" - Henry David Thoreau",
    "\"The road to success and the road to failure are almost exactly the same.\" - Colin R. Davis",
    "\"Your work is going to fill a large part of your life, and the only way to be truly satisfied is to do what you believe is great work. And the only way to do great work is to love what you do.\" - Steve Jobs",
    "\"When one door of happiness closes, another opens; but often we look so long at the closed door that we do not see the one which has been opened for us.\" - Helen Keller",
    "\"The difference between a successful person and others is not a lack of strength, not a lack of knowledge, but rather a lack of will.\" - Vince Lombardi",
    "\"I can't change the direction of the wind, but I can adjust my sails to always reach my destination.\" - Jimmy Dean",
    "\"The mind is everything. What you think you become.\" - Buddha",
    "\"The only limit to our realization of tomorrow will be our doubts of today.\" - Franklin D. Roosevelt",
    "\"The only person you should try to be better than is the person you were yesterday.\" - Matty Mullins",
    "\"You miss 100% of the shots you don't take.\" - Wayne Gretzky",
    "\"The best revenge is massive success.\" - Frank Sinatra",
    "\"Believe in yourself, take on your challenges, dig deep within yourself to conquer fears. Never let anyone bring you down. You got this.\" - Chantal Sutherland",
    "\"The only thing standing between you and your goal is the story you keep telling yourself as to why you can't achieve it.\" - Jordan Belfort",
    "\"Success is not the key to happiness. Happiness is the key to success. If you love what you are doing, you will be successful.\" - Albert Schweitzer",
    "\"Don't watch the clock; do what it does. Keep going.\" - Sam Levenson",
    "\"The biggest adventure you can take is to live the life of your dreams.\" - Oprah Winfrey",
    "\"The only limit to our realization of tomorrow will be our doubts of today.\" - Franklin D. Roosevelt",
    "\"Success is not the absence of failure; it's the persistence through failure.\" - Aisha Tyler"
]



button.addEventListener('click', e => {
    e.preventDefault();
    getRandomQuote(quotes);

} );




// async function getQuote() {
//     const response = await fetch('https://zenquotes.io/api/quotes');
//     if(!response.ok) {
//         throw Error(response.statusText); //403 404 etc.
//     }
//     const json = await response.json();
//     displayQuote(json.message)
// }
// Uncaught SyntaxError: Unexpected token ')'

// function displayQuote(quote) {
//     const quoteText = document.querySelector('#quote-text')
//     quoteText.textContent = quote;
// }   

function getRandomQuote(arr) {
    let randomIndex = Math.floor(Math.random() * arr.length);

    let randomQuote = arr[randomIndex];
    container.innerText = randomQuote;
    randomQuote = randomQuote.replace(' ', '%20');
    a.setAttribute('href', "https://twitter.com/compose/tweet?text=" +randomQuote+"")
    a.setAttribute('target', "_blank")
    a.innerHTML = 'Like this quote? Click here to tweet it!'
}

document.getElementsByTagName('body')[0].appendChild(a);

//<!-- <a href="https://twitter.com/compose/tweet?text=Hello%20world" target="_blank" onclick="chrome.tabs.create({url:this.href})">Like this quote? Click here to tweet it!</a> -->
