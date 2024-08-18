function makeChoice(choice) {
    let description = '';
    let options = [];

    switch(choice) {
        case 'Pegar o pão':
            description = 'Você pegou o pão. Agora, o que você faz?';
            options = ['Pegar o ovo', 'Acender o fogão', 'Cortar o pão'];
            break;
        case 'Pegar o ovo':
            description = 'Você pegou o ovo. Agora, o que você faz?';
            options = ['Pegar o pão', 'Acender o fogão', 'Quebrar o ovo na frigideira'];
            break;
        case 'Acender o fogão':
            description = 'Você acendeu o fogão. Agora, o que você faz?';
            options = ['Pegar o pão', 'Pegar o ovo', 'Colocar uma frigideira no fogão'];
            break;
        case 'Cortar o pão':
            description = 'Você cortou o pão. Agora, o que você faz?';
            options = ['Pegar o ovo', 'Acender o fogão', 'Colocar o pão na frigideira'];
            break;
        case 'Quebrar o ovo na frigideira':
            description = 'Você quebrou o ovo na frigideira e começou a cozinhar. Está quase pronto!';
            options = ['Acender o fogão', 'Torrar o pão', 'Servir o pão com ovo'];
            break;
        case 'Colocar uma frigideira no fogão':
            description = 'Você colocou a frigideira no fogão. Agora, o que você faz?';
            options = ['Quebrar o ovo na frigideira', 'Cortar o pão', 'Pegar o pão'];
            break;
        case 'Torrar o pão':
            description = 'Você torrou o pão. Agora, está na hora de servir!';
            options = ['Servir o pão com ovo'];
            break;
        case 'Servir o pão com ovo':
            description = 'Parabéns! Você preparou um delicioso pão com ovo!';
            options = ['Recomeçar'];
            break;
        case 'Recomeçar':
            description = 'Você está na cozinha e decidiu preparar um delicioso pão com ovo. O que você faz primeiro?';
            options = ['Pegar o pão', 'Pegar o ovo', 'Acender o fogão'];
            break;
        default:
            description = 'Escolha uma ação válida.';
            options = ['Pegar o pão', 'Pegar o ovo', 'Acender o fogão'];
            break;
    }

    document.getElementById('description').textContent = description;

    const optionsDiv = document.getElementById('options');
    optionsDiv.innerHTML = '';
    options.forEach(option => {
        const button = document.createElement('button');
        button.textContent = option;
        button.onclick = () => makeChoice(option);
        optionsDiv.appendChild(button);
    });
}
