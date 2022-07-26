package com.tst.common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.JoinRowSet;

public class BoardDAO extends DAO {

	// 등록
	public void insertBoard(BoardVO vo) {
		try {
			connect();
			String sql = "INSERT INTO board "
					+ " VALUES((SELECT nvl(MAX(board_id),0)+1 FROM board), ?, ?, ?, sysdate, 0)";
			// board_id의 max값에 +1해서 시퀀스처럼 사용
			// 값이 없을때는 0이 출력되게 하려고 nvl함수 사용
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getWriter());

			int r = pstmt.executeUpdate();
			System.out.println(r + "건 입력");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 목록
	public List<BoardVO> boardList() {
		List<BoardVO> list = new ArrayList<>();

		try {
			connect();
			String sql = "SELECT * FROM board ORDER BY 1";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setBoardId(rs.getInt("board_id"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setCreateDate(rs.getString("create_date"));
				vo.setView(rs.getInt("board_view"));
				list.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return list;
	}
	
	public BoardVO getBoard(int boardNo) {
		BoardVO vo = new BoardVO();

		try {
			connect();
			String sql = "SELECT * FROM board WHERE board_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo.setBoardId(rs.getInt("board_id"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setCreateDate(rs.getString("create_date"));
				vo.setView(rs.getInt("board_view"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return vo;
	}
	
	// update
		public void updateBoard(int boardNo) {
			try {
				connect();
				String sql = "UPDATE board SET board_view=board_view+1 WHERE board_id = ?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, boardNo);

				int r = pstmt.executeUpdate();
				System.out.println(r + "건 입력");

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}
		}
		
	// 글 내용 수정
		public void updateBoard(BoardVO vo) {
			try {
				connect();
				String sql = "update board set title=?, content=? where board_id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getTitle());
				pstmt.setString(2, vo.getContent());
				pstmt.setInt(3, vo.getBoardId());
				
				int r = pstmt.executeUpdate(); // 쿼리실행
				System.out.println(r + "건 변경.");
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}
			
		}
		
		
		
		// 글 내용 삭제
		public void deleteBoard(int BoardNo) {
			try {
				connect();
				String sql = "delete from board where board_id=?";
				pstmt = conn.prepareCall(sql);
				pstmt.setInt(1, BoardNo);
				
				int r = pstmt.executeUpdate();
				System.out.println(r + "건 삭제.");
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}
		}
		
		
		
		// 로그인 체크
		public userVO loginCheck(String id, String pass) {
			try {
				connect();
				String sql = "select * from users where id=? and passwd=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2, pass);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					userVO vo = new userVO();
					vo.setId(rs.getString("id"));
					vo.setPasswd(rs.getString("passwd"));
					vo.setName(rs.getString("name"));
					
					return vo;
				}
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}
			return null;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
