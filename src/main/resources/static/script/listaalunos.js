document.addEventListener("DOMContentLoaded", function () {
    const contentArea = document.querySelector(".content-area");
    const listaTurmas = document.getElementById("turma-lista");
  
    const urlParams = new URLSearchParams(window.location.search);
    const turmaId = urlParams.get("turmaId");
  
    if (!turmaId) {
      contentArea.innerHTML = "<p>Turma não especificada.</p>";
      return;
    }
  
    carregarTurmas();      // carrega as turmas no menu lateral
    carregarAlunos(turmaId); // carrega os alunos da turma atual
  
    function carregarTurmas() {
      fetch("http://localhost:8080/turmas")
        .then((res) => res.json())
        .then((turmas) => {
          listaTurmas.innerHTML = "";
  
          turmas.forEach((turma) => {
            const li = document.createElement("li");
            const botao = document.createElement("button");
            botao.textContent = turma.nomeTurma;
            botao.classList.add("btn-cadastro");
  
            botao.addEventListener("click", () => {
              window.location.href = `listaalunos.html?turmaId=${turma.idTurma}`;
            });
  
            li.appendChild(botao);
            listaTurmas.appendChild(li);
          });
        })
        .catch((error) => {
          console.error("Erro ao carregar turmas:", error);
        });
    }
  
    function carregarAlunos(turmaId) {
      fetch(`http://localhost:8080/alunos/turma/${turmaId}`)
        .then((res) => res.json())
        .then((alunos) => {
          contentArea.innerHTML = "";
  
          if (alunos.length === 0) {
            contentArea.innerHTML = "<p>Nenhum aluno encontrado para esta turma.</p>";
            return;
          }
  
          const container = document.createElement("div");
          container.classList.add("aluno-container");
  
          alunos.forEach((aluno) => {
            const card = document.createElement("div");
            card.classList.add("aluno-card");
  
            const img = document.createElement("img");
            img.src = aluno.imagemAluno || "images/user-placeholder.png"; // imagem default
            img.alt = aluno.nomeAluno;
            img.classList.add("foto-aluno");
  
            const nome = document.createElement("p");
            nome.textContent = aluno.nomeAluno;
  
            card.appendChild(img);
            card.appendChild(nome);
  
            // clique redireciona para o perfil
            card.addEventListener("click", () => {
              window.location.href = `perfilaluno.html?alunoId=${aluno.idAluno}`;
            });
  
            container.appendChild(card);
          });
  
          contentArea.appendChild(container);
        })
        .catch((error) => {
          console.error("Erro ao carregar alunos:", error);
          contentArea.innerHTML = "<p>Erro ao carregar alunos.</p>";
        });
    }
  });
  