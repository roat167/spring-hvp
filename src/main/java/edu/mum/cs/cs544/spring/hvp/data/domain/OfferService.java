package edu.mum.cs.cs544.spring.hvp.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**  
 * @author roat
 *
 */
@Entity
@Table(name = "offer_service", catalog = "hvp")
public class OfferService implements java.io.Serializable {
	private static final long serialVersionUID = 8009137559231451464L;
	private int id;
	private User userId;
	private Task taskId;

	public OfferService() {
	}

	public OfferService(int id, User userId, Task taskId) {
		this.id = id;
		this.userId = userId;
		this.taskId = taskId;		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="user_id", nullable = false)
	public User getUserId() {
		return this.userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	@ManyToOne
	@JoinColumn(name="task_id", nullable = false)
	public Task getTaskId() {
		return this.taskId;
	}

	public void setTaskId(Task taskId) {
		this.taskId = taskId;
	}

}
