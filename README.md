# K9care
<p>
  Pequeno sistema de adoção de Cães e Gatos.
</p>

#

<h2>Inicialização</h2>

<h3>1. É necessário ter a seguinte estrutura:</h3>

- [X] Eclipse ou qualquer outra plataforma Java;
- [X] Oracledb ou Postgresql;
- [X] GIT;
- [ ] Driver oracle db local;
- [ ] mysql workbench(caso queira abrir o arquivo <b><em>bd_logico_sql-scheme.mwb</em></b>);

#

<h3>2. Mude para branch develop com o seguinte comando:</h3>
<br>

```
git checkout develop
```

<h3>3. Vá até a pasta:</h3>

```
k9care/src/META-INF/persistence.xml
``` 
#

<h3>4. Ajuste seu usuário e senha para o de seu banco local.</h3>
<p>Ex:</p>

```
user: value="user"
password: value="password"
``` 

#

<h3>6. Altere o caminho de seu Driver Oracledb no arquivo <em>pom.xml</em> localizado em:</h3>

```
k9care/pom.xml
``` 

#

<h3>7. Execute o arquivo  <em>View</em> localizado em:</h3>

```
k9care/src/br/com/k9care/view
``` 
#

  ## Authors
  
  * **[Gustavo Bossolani](http://github.com/gustavo-bossolani)**.
