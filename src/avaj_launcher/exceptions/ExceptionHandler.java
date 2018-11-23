// ************************************************************************** //
//                                                                            //
//                                                        :::      ::::::::   //
//   ExceptionHandler.java                              :+:      :+:    :+:   //
//                                                    +:+ +:+         +:+     //
//   By: wto <marvin@42.fr>                         +#+  +:+       +#+        //
//                                                +#+#+#+#+#+   +#+           //
//   Created: 2018/11/23 15:41:43 by wto               #+#    #+#             //
//   Updated: 2018/11/23 15:41:43 by wto              ###   ########.fr       //
//                                                                            //
// ************************************************************************** //

package avaj_launcher.exceptions;

public class ExceptionHandler
{
	private ExceptionHandler()
	{
		// do nothing
	}

	public static void exit(Exception e)
	{
		System.out.println(e);
		System.exit(1);
	}
}