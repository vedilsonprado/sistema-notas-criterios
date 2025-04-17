document.addEventListener("DOMContentLoaded", function () {
    const listaTurmas = document.getElementById("turma-lista");
  
    // Função para buscar turmas da API
    function carregarTurmas() {
      fetch("http://localhost:8080/turmas") // endpoint que lista as turmas
        .then((response) => {
          if (!response.ok) {
            throw new Error("Erro ao buscar turmas");
          }
          return response.json();
        })
        .then((turmas) => {
          listaTurmas.innerHTML = ""; // limpa o conteúdo
  
          turmas.forEach((turma) => {
            const li = document.createElement("li");
            const botao = document.createElement("button");
            botao.textContent = turma.nomeTurma;
            botao.classList.add("btn-cadastro");
  
            // Redireciona para listaalunos.html passando o ID da turma como parâmetro
            botao.addEventListener("click", function () {
              window.location.href = `pages/listaalunos.html?turmaId=${turma.idTurma}`;
            });
  
            li.appendChild(botao);
            listaTurmas.appendChild(li);
          });
        })
        .catch((error) => {
          console.error("Erro ao carregar turmas:", error);
          listaTurmas.innerHTML = "<li>Erro ao carregar turmas</li>";
        });
    }
  
    // Chama a função ao carregar a página
    carregarTurmas();
  });
  