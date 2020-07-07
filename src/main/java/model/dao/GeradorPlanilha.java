package model.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.mysql.cj.result.Row;

import model.vo.Animal;
import model.vo.Cliente;

public class GeradorPlanilha {

	public String gerarPlanilhaClientes(String caminhoArquivo, ArrayList<Cliente> clientes) {

		XSSFWorkbook planilha = new XSSFWorkbook();

		
		XSSFSheet aba = planilha.createSheet("Clientes");

		String[] nomesColunas = { "#", "Nome", "Cpf", "Rua", "Número", "CEP", "Bairro", "Telefone", "email" };

		XSSFWorkbook planilhas = new XSSFWorkbook();
		XSSFSheet abaPlanilha = planilha.createSheet("Usuarios");

		
		Row linhaCabecalho = (Row) abaPlanilha.createRow(0);

		for (int i = 0; i < nomesColunas.length; i++) {
			Cell celula = ((XSSFRow) linhaCabecalho).createCell(i);
			celula.setCellValue(nomesColunas[i]);
		}

		
		int linhaAtual = 1;
		return salvarNoDisco(planilha, caminhoArquivo, ".xlsx");
	}

	private void criarLinhasClientea(ArrayList<Cliente> clientes, XSSFSheet aba, int posicaoLinhaAtual) {

		for (Cliente c : clientes) {
			XSSFRow linhaAtual = aba.createRow(posicaoLinhaAtual);

			linhaAtual.createCell(0).setCellValue(c.getId());
			linhaAtual.createCell(1).setCellValue(c.getNome());
			linhaAtual.createCell(2).setCellValue(c.getCpf());
			linhaAtual.createCell(2).setCellValue(c.getRua());
			linhaAtual.createCell(3).setCellValue(c.getBairro());
			linhaAtual.createCell(4).setCellValue(c.getNumero());
			linhaAtual.createCell(5).setCellValue(c.getCep());
			linhaAtual.createCell(6).setCellValue(c.getTelefone());
			linhaAtual.createCell(7).setCellValue(c.getEmail());

			posicaoLinhaAtual++;
		}	
	}

	private void criarCabecalho(String[] nomesColunas, XSSFSheet aba, int posicaoLinhaAtual) {
		Row linhaAtual = (Row) aba.createRow(posicaoLinhaAtual);

		posicaoLinhaAtual++;

	}

	private String salvarNoDisco(XSSFWorkbook planilha, String caminhoArquivo, String extensao) {
		String mensagem = "";
		FileOutputStream saida = null;

		try {
			saida = new FileOutputStream(new File(caminhoArquivo + extensao));
			planilha.write(saida);
			mensagem = "Planilha gerada com sucesso!";
		} catch (FileNotFoundException e) {
			mensagem = "Erro ao tentar salvar planilha em: " + caminhoArquivo + extensao;
			System.out.println("Causa: " + e.getMessage());
		} catch (IOException e) {
			mensagem = "Erro ao tentar salvar planilha em: " + caminhoArquivo + extensao;
			System.out.println("Causa: " + e.getMessage());
		} finally {
			if (saida != null) {
				try {
					saida.close();
					planilha.close();
				} catch (IOException e) {
					mensagem = "Erro ao tentar salvar planilha em: " + caminhoArquivo + extensao;
					System.out.println("Causa: " + e.getMessage());
				}
			}
		}

		return mensagem;
	}

	public void gerarPlanilhaAnimais(String caminhoEscolhido, List<Animal> animal) {
		// TODO Auto-generated method stub
		
	}

}