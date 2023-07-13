const pokedex = document.querySelector('.pokedex');

const faicose = async function (pkmnId) {
  const response = await fetch(`https://pokeapi.co/api/v2/pokemon/${pkmnId}`);
  const data = response.json();
  return data;
}
const fetchDescription = async function (pkmnId) {
  const response = await fetch(`https://pokeapi.co/api/v2/pokemon-species/${pkmnId}/`);
  const data = response.json();
  return data;
}

for (let i = 1; i <= 1010; i++) {
  faicose(i)
    .then(data => {

      /* console.log(data); */

      const card = document.createElement('div');
      const pkmnImg = document.createElement('img');
      const pkmnTitle = document.createElement('p')
      pkmnTitle.textContent = data.name;

      pkmnImg.src = data.sprites.front_default;

      pokedex.append(card);
      card.append(pkmnImg);
      card.append(pkmnTitle);

      pokedex.classList.add("main-content")
      card.classList.add("card");
      const buttonDetails = document.createElement('button')
      buttonDetails.textContent = "dettagli";
      buttonDetails.setAttribute('id', i);
      buttonDetails.setAttribute('detailsHidden', 'true')
      const pkmnDexcription = document.createElement('p');

      buttonDetails.addEventListener('click', () => {
        console.log(buttonDetails.getAttribute('id'));

        /* const pippo = buttonDetails.getAttribute('detailsHidden');
        console.log(pippo); */

        if (buttonDetails.getAttribute('detailsHidden') == 'true') {
          fetchDescription(i)
            .then(data => {

              for (const description of data.flavor_text_entries) {


                if (description.language.name == 'it') {
                  console.log(description.flavor_text);

                  pkmnDexcription.textContent = description.flavor_text;
                  card.append(pkmnDexcription);
                  buttonDetails.setAttribute('detailsHidden', 'false');

                  break;
                }
              }
            });
        }
        else {
          buttonDetails.setAttribute('detailsHidden', 'true');
          pkmnDexcription.textContent = "";
        }

      })

      card.append(buttonDetails)

    })
    .catch(e => {
      console.log(e);
    })
}