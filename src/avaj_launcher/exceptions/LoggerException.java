// ************************************************************************** //
//                                                                            //
//                                                        :::      ::::::::   //
//   LoggerException.java                               :+:      :+:    :+:   //
//                                                    +:+ +:+         +:+     //
//   By: wto <marvin@42.fr>                         +#+  +:+       +#+        //
//                                                +#+#+#+#+#+   +#+           //
//   Created: 2018/11/23 15:41:49 by wto               #+#    #+#             //
//   Updated: 2018/11/23 15:41:49 by wto              ###   ########.fr       //
//                                                                            //
// ************************************************************************** //

package avaj_launcher.exceptions;

public class LoggerException extends Exception
{
	public LoggerException(String message)
	{
		super(message);
	}
}