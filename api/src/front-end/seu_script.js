document.getElementById("loginForm").addEventListener("submit", (event) => {
    event.preventDefault(); // Evita o comportamento padrão do formulário

    const login = document.getElementById("login").value;
    const senha = document.getElementById("senha").value;

    // Faça uma chamada à sua API para autenticar o usuário
    fetch('http://localhost:8080/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ login, senha }),
    })
        .then(response => {
            if (response.status === 200) {
                // Autenticação bem-sucedida, redirecione ou exiba uma mensagem
                document.getElementById("resultado").textContent = "Login bem-sucedido!";
            } else {
                // Autenticação falhou, exiba uma mensagem de erro
                document.getElementById("resultado").textContent = "Nome de usuário ou senha incorretos.";
            }
        })
        .catch(error => {
            console.error('Erro ao fazer login:', error);
        });
});
